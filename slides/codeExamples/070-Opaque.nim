type
  Dollar = distinct int
  Euro = distinct int

proc `+` (x, y: Dollar): Dollar =
  result = Dollar(int(x) + int(y))  

proc `*` (x: Dollar, y: int): Dollar =
  result = Dollar(int(x) * y)

proc `*` (x: int, y: Dollar): Dollar =
  result = Dollar(x * int(y))

# or

# proc `*` (x: Dollar, y: int): Dollar {.borrow.}
# proc `*` (x: int, y: Dollar): Dollar {.borrow.}

var
  d: Dollar
  e: Euro

echo d + 12 # Error: cannot add a number with no unit and a `Dollar`

var a = 20.Dollars
a = 25  # Doesn't compile
a = 25.Dollars  # Works fine
a = 20.Dollars + 20.Dollars # Works fine
a = 2 * a