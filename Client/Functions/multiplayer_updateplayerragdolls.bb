Function multiplayer_updateplayerragdolls%(arg0.players)
    If (arg0\Field42\Field8 <> $00) Then
        rd_update(arg0\Field42\Field9[$00])
        rd_update(arg0\Field42\Field9[$01])
    EndIf
    Return $00
End Function
