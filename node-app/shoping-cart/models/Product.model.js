const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const ProductSchema = new Schema([{
    name: String,
    price: Schema.Types.Decimal128,
    stock: { type: Number, min: 0 },
}]);

mongoose.model('Product', ProductSchema);
