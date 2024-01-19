Function multiplayer_setplayerroom%(arg0.players)
    If (room[arg0\Field47] <> Null) Then
        arg0\Field46 = room[arg0\Field47]\Field7\Field11
    EndIf
    Return $00
End Function
