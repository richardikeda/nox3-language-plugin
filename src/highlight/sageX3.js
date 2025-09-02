export default function(hljs) {
  const KEYWORDS = [
    'if', 'then', 'elsif', 'endif',
    'else',
    'for', 'to', 'downto', 'next',
    'repeat', 'until',
    'while', 'wend',
    'case', 'when', 'otherwise', 'endcase'
  ];

  const TYPES = [
    'integer', 'decimal', 'float', 'date', 'string', 'char'
  ];

  const BUILT_INS = [
    'len', 'substr', 'chr', 'asc', 'val', 'str', 'upper', 'lower'
  ];

  const IF_BLOCK = {
    beginKeywords: 'if',
    end: 'endif',
    contains: [
      { beginKeywords: 'then' },
      { beginKeywords: 'elsif' },
      { beginKeywords: 'else' },
      'self'
    ]
  };

  const FOR_BLOCK = {
    beginKeywords: 'for',
    end: 'next',
    contains: [
      { beginKeywords: 'to downto' },
      'self'
    ]
  };

  const REPEAT_BLOCK = {
    beginKeywords: 'repeat',
    end: 'until'
  };

  const WHILE_BLOCK = {
    beginKeywords: 'while',
    end: 'wend',
    contains: ['self']
  };

  const CASE_BLOCK = {
    beginKeywords: 'case',
    end: 'endcase',
    contains: [
      { beginKeywords: 'when' },
      { beginKeywords: 'otherwise' },
      'self'
    ]
  };

  return {
    name: 'Sage X3',
    case_insensitive: true,
    keywords: {
      keyword: KEYWORDS.join(' '),
      type: TYPES.join(' '),
      built_in: BUILT_INS.join(' ')
    },
    contains: [
      hljs.COMMENT('#', '$'),
      hljs.APOS_STRING_MODE,
      hljs.QUOTE_STRING_MODE,
      { className: 'number', begin: '\\b\\d+(\\.\\d+)?', relevance: 0 },
      { className: 'operator', begin: /[\-+*\/%=<>!]+/ },
      IF_BLOCK,
      FOR_BLOCK,
      REPEAT_BLOCK,
      WHILE_BLOCK,
      CASE_BLOCK
    ]
  };
}
