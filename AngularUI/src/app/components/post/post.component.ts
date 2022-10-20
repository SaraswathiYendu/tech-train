import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/models/Post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  posts: Post[];
  constructor(private postService:
                    PostService) { }

  ngOnInit(): void {
    this.postService.getAllPosts()
    .subscribe(data=>{
      this.posts = data;
    });
  }

}
