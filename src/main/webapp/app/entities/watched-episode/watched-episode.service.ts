import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IWatchedEpisode } from 'app/shared/model/watched-episode.model';
import {map} from "rxjs/operators";
import * as moment from "moment";

type EntityResponseType = HttpResponse<IWatchedEpisode>;
type EntityArrayResponseType = HttpResponse<IWatchedEpisode[]>;

@Injectable({ providedIn: 'root' })
export class WatchedEpisodeService {
    public resourceUrl = SERVER_API_URL + 'api/watched-episodes';

    constructor(private http: HttpClient) {}

    create(watchedEpisode: IWatchedEpisode): Observable<EntityResponseType> {
        return this.http.post<IWatchedEpisode>(this.resourceUrl, watchedEpisode, { observe: 'response' });
    }

    update(watchedEpisode: IWatchedEpisode): Observable<EntityResponseType> {
        return this.http.put<IWatchedEpisode>(this.resourceUrl, watchedEpisode, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IWatchedEpisode>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    findByEpisodeId(id: number): Observable<EntityResponseType>{
        return this.http
            .get<IWatchedEpisode>(`${this.resourceUrl}/episode/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => WatchedEpisodeService.convertDateFromServer(res)));
    }

    getAverageRate(episodeId: number): Observable<EntityResponseType> {
        return this.http.get<IWatchedEpisode>(`${this.resourceUrl}/${episodeId}/average-rate`, { observe: 'response' });
    }

    getRateCount(episodeId: number): Observable<EntityResponseType> {
        return this.http.get<IWatchedEpisode>(`${this.resourceUrl}/${episodeId}/rate-count`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IWatchedEpisode[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected static convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.episode.releaseDate = res.body.episode.releaseDate != null ? moment(res.body.episode.releaseDate) : null;
        }
        return res;
    }
}
