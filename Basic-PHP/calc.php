<?php
if (isset($_POST['calculate'])) {
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];
    $operator = $_POST['operator'];

    switch ($operator) {
        case '+':
            $result = $num1 + $num2;
            break;
        case '-':
            $result = $num1 - $num2;
            break;
        case '*':
            $result = $num1 * $num2;
            break;
        case '/':
            if ($num2 == 0) {
                $result = "Cannot divide by zero";
            } else {
                $result = $num1 / $num2;
            }
            break;
        default:
            $result = "Invalid operator";
            break;
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form action="calculator.php" method="post">
        <input type="number" name="num1" value="<?php echo $num1 ?? ''; ?>" required>
        <select name="operator">
            <option value="+" <?php if ($operator == '+') echo 'selected'; ?>>+</option>
            <option value="-" <?php if ($operator == '-') echo 'selected'; ?>>-</option>
            <option value="*" <?php if ($operator == '*') echo 'selected'; ?>>*</option>
            <option value="/" <?php if ($operator == '/') echo 'selected'; ?>>/</option>
        </select>
        <input type="number" name="num2" value="<?php echo $num2 ?? ''; ?>" required>
        <button type="submit" name="calculate">Calculate</button>
        <?php if (isset($result)) echo "<p>Result: $result</p>"; ?>
    </form>
</body>
</html>
       
