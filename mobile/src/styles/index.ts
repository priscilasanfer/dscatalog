import { StyleSheet } from "react-native"

const colors = { 
    white: "#FFFFFF",
    lightGray: "#F2F2F2", 
    mediumGray: "#9E9E9E",
    darkGray: "#263238",
    borderGrey: "#E1E1E1",
    black: "#000000",
    primary: "#407BEE",
    secondary: "#33569B",
    bluePill: "#407BFF61",
    red: "#DF5753"
}

const text = StyleSheet.create({
    regular: {
        fontSize:16,
        fontWeight: "400",
        textAlign: "center",
        color: colors.mediumGray
    },
    bold: {
        fontSize: 26,
        fontWeight: "bold",
        textAlign: "center",
        marginBottom:  15,
        color: colors.darkGray,
    },
    primaryText:{
        fontSize: 16,
        fontWeight: "bold",
        textTransform: "uppercase",
        color: colors.white,
        marginLeft: 20
    },
    productName: {
        fontSize: 16,
        fontWeight: "bold"
    },
    currency: {
        fontSize: 16,
        fontWeight: "400",
        color: colors.mediumGray
    },
    productPrice:{
        fontSize: 30,
        color: colors.primary,
        fontWeight: "bold"

    },
    goBackText:{
        fontSize: 18,
        fontWeight: "bold",
        textTransform: "uppercase",
        color: colors.darkGray,
        marginLeft: 16
    },
    productDetailsName: {
        fontSize: 30,
        fontWeight: "bold",
        marginTop: 10,
        color:colors.darkGray
    },
    productDescription:{
        fontSize: 16,
        fontWeight: "400",
        color: colors.mediumGray,
    }
})

const theme = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        padding: 20
    },

    card: {
        width: '100%',
        height: '100%',
        backgroundColor: colors.white,
        borderRadius: 20,
        alignItems: 'center',
        shadowColor: colors.black,
        shadowOffset:{
            width: 0,
            height: 2
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        justifyContent: 'space-around'
    },
    draw: {
        width: 313,
        height: 225
    },
    textContainer: {
        paddingHorizontal: 20,
    },
    primaryButton:{
        width: 290,
        height: 50,
        backgroundColor:  colors.primary,
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        borderRadius: 10
    },
    arrowContainer: {
        backgroundColor: colors.secondary,
        height:50,
        width: 50,
        borderTopRightRadius:10,
        borderBottomRightRadius: 10,
        alignItems: "center",
        justifyContent: "center"
    },
    scrollContainer:{
        padding:10,
    },
    productCard: {
        width: '100%',  
        backgroundColor: colors.white,
        borderRadius: 10,
        shadowColor: colors.black,
        shadowOffset:{
            width: 0,
            height: 2
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        marginVertical:10,
        alignItems: "center",
        justifyContent: "space-around"
    },
    productDescription: {
        width: "100%",
        padding: 20,
        borderTopColor: colors.lightGray,
        borderTopWidth: 1
    },
    priceContainer:{
        flexDirection: "row",
        marginTop: 10
    },
    inputContainer: {
        width: '100%', 
        height: 60,
        backgroundColor: colors.white,
        borderRadius: 10,
        shadowColor: colors.black,
        shadowOffset:{
            width: 0,
            height: 2
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        alignItems: "center",
        marginVertical:12.5 ,
        paddingVertical:10 
    },
    searchInput:{
        width: '90%', 
        height: 40,
        borderBottomWidth: 0.5,
        borderBottomColor: colors.borderGrey

    },
    productImg: {
        width: 140, 
        height: 140,
        margin: 16
    },
    detailsContainer: {
        backgroundColor: colors.white,
        padding: 20
    },

    detailCard: {
        width: '100%',
        height: '100%',
        backgroundColor: colors.white,
        borderRadius: 20,
        shadowColor: colors.black,
        shadowOffset:{
            width: 0,
            height: 2
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        justifyContent: 'space-around',
        padding: 20
    },
    productImageContainer:{
        width: '100%',
        borderWidth: 1,
        borderColor: colors.lightGray,
        alignItems: "center",
        borderRadius: 20
    },
    productImage: {
        width: 220, 
        height: 220
    },
    goBackContainer:{
        width: 290,
        flexDirection: "row",
        alignItems: "center",
        marginVertical: 10,
        justifyContent: "flex-start"
    },
    scrollTextContainer: {
        marginVertical: 20,
        padding: 20,
        borderWidth: 0.5,
        borderColor: colors.lightGray,
        borderRadius: 10,
    }
    
})



export {colors, theme, text}