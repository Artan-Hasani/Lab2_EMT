import axios from "../custom-axios/axios";

const EShopService = {
    fetchBooks: () => {
       return  axios.get('/books')
    },
    fetchCategories: () => {
        return  axios.get('/books/categories')
    },
    fetchAuthors: () => {
        return  axios.get('/authors')
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    takeBook: (id) => {
        return axios.put(`/books/take/${id}`);
    },
    getAuthor: (id) => {
        return axios.get(`/authors/${id}`);
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/create", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
}
export default EShopService;