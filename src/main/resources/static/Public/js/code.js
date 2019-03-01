function create_code() {
    function shuffle() {
        var arr = ['1','2','3','4','5','6','7','8','9','0','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'];
        return arr.sort(function () {
            return (Math.random() - .5);
        });
    };
    shuffle();
    function show_code() {
        var ar1 = '';
        var code = shuffle();
        for (var i = 0; i < 4; i++) {
            ar1 += code[i];
        }
        ;
        //var ar=ar1.join('');
        $(".yzmCode").text(ar1);
    };
    show_code();
    $(".yzmCode").click(function () {
        show_code();
    });
}
