Function breach_isstarted%()
    Return ((gameinfo\Field5\Field2 < millisecs()) And (gameinfo\Field5\Field2 <> $00))
    Return $00
End Function
