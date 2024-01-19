Function breach_givetickets%(arg0%, arg1#)
    Select arg0
        Case $00
            gameinfo\Field5\Field9 = (gameinfo\Field5\Field9 + arg1)
        Case $01
            gameinfo\Field5\Field10 = (gameinfo\Field5\Field10 + arg1)
    End Select
    Return $00
End Function
