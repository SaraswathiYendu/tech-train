import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/models/Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { } //--> DI: HttpClient is injected

  getAllPosts(): Observable<Post[]>{
      return this.http.get<Post[]>('https://jsonplaceholder.typicode.com/posts');
  }
}
