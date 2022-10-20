import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/services/todo.service';
import { Todo } from 'src/models/Todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todos: Todo[];
  constructor(private todoService: TodoService) {
    console.log('constructor called...');
  }

  ngOnInit(): void {
    console.log('ngOninit called...');
      this.todoService.getAllTodos().subscribe(data=>{
          this.todos = data;
      })
  }

}
