// const tokenListStr = require('./tokenList.js');

const tokenListStr = `
T_INT,
T_CHAR,
T_FLOAT,
T_LONG,
T_VOID,
T_ENUM,
T_STRUCT,
T_UNION,
T_TYPEDEF,

T_FOR,
T_WHILE,
T_IF,
T_ELSE,
T_SWITCH,
T_CASE,
T_BREAK,
T_CONTINUE,
T_RETURN,
T_GOTO,

T_EOF,
T_ERROR,
`;

function extractToken(tokenStr) {
  return tokenStr.substring(2, tokenStr.length);
}

function tokenToScannerReturn(tokenStr) {
  const tokenName = tokenStr.toLowerCase();
  return `${tokenName} return(T_${tokenStr});`;
}

const tokenList = tokenListStr.replace(/\n| /g, '').split(',').map(extractToken);

const scannerReturnStr = tokenList.reduce((agg, cur) => {
  return agg.concat(tokenToScannerReturn(cur), '\n');
}, '');

console.log(scannerReturnStr);
