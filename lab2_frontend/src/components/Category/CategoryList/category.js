import React from "react";
import CategoryData from  "../CategoryData/categoryData"

class Category extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {

        const allCategories = this.getBooksPage();

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Category</th>
                            </tr>
                            </thead>

                            <tbody>
                            {allCategories}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }

    getBooksPage = () => {
        return this.props.categories.map((term) => {
            return (
                <CategoryData key={term} term={term} />
            );
        })
    }
}

export default Category;