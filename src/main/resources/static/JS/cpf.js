
function formatarCPF(event) {
    var cpf = event.target.value;
    var cpfNumeros = cpf.replace(/\D/g, '');
    var cpfFormatado = '';
    if (cpfNumeros.length > 0) {
        cpfFormatado = cpfNumeros.substring(0, 3);
        if (cpfNumeros.length > 3) {
            cpfFormatado += '.' + cpfNumeros.substring(3, 6);
        }
        if (cpfNumeros.length > 6) {
            cpfFormatado += '.' + cpfNumeros.substring(6, 9);
        }
        if (cpfNumeros.length > 9) {
            cpfFormatado += '-' + cpfNumeros.substring(9, 11);
        }
    }
    event.target.value = cpfFormatado;
}