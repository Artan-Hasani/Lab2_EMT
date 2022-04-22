import './App.css';
import React, {Component} from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Books from "../Book/BookList/books"
import Header from "../Header/header"
import EShopService from "../../repository/EShopRepository";
import BookAdd from "../Book/BookAdd/bookAdd";
import BookEdit from "../Book/BookEdit/bookEdit";
import Category from "../Category/CategoryList/category"
class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
        books: [],
        categories: [],
        authors: [],
        selectedBook: {}

    }
  }

  render() {

    return (
            <Router>
                <Header/>
                <Routes>
                    <Route path="/" element={<Books books={this.state.books}
                                                         onDelete={this.deleteBook}
                                                         onEdit={this.getBook}
                                                         onGetBook={this.takeBook}/>}/>
                    <Route path="/books" element={<Books books={this.state.books}
                                                         onDelete={this.deleteBook}
                                                         onEdit={this.getBook}
                                                         onGetBook={this.takeBook}/>}/>
                    <Route path="/books/add" element={<BookAdd categories={this.state.categories}
                                                               authors={this.state.authors}
                                                               onAddBook={this.addBook}/>}/>
                    <Route path="/books/edit/:id" element={<BookEdit categories={this.state.categories}
                                                               authors={this.state.authors}
                                                               onEditBook={this.editBook}
                                                               book={this.state.selectedBook}/>}/>
                    <Route path="/categories" element={<Category categories={this.state.categories}/>}/>
                </Routes>
            </Router>
    );
  }

  componentDidMount() {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }

  loadBooks = () => {
    EShopService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }
    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }
    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
    takeBook = (id) => {
        EShopService.takeBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        EShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    addBook = (name, category, author, availableCopies) => {
        EShopService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
    editBook = (id, name, category, author, availableCopies) => {
        EShopService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
