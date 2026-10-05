Function multiplayer_setplayerroom%(arg0.players)
    If (room[arg0\Field45] <> Null) Then
        arg0\Field44 = room[arg0\Field45]\Field8\Field11
    EndIf
    Return $00
End Function
