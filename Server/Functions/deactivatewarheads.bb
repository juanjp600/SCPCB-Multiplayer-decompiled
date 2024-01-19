Function deactivatewarheads%(arg0%)
    If (getscripts() <> 0) Then
        public_inqueue($46, $00)
        public_addparam($00, (Str arg0), $01)
        callback($00)
    EndIf
    gameinfo\Field5\Field6 = $00
    gameinfo\Field5\Field11 = ""
    gameinfo\Field5\Field1 = gameinfo\Field5\Field0
    gameinfo\Field5\Field5 = gameinfo\Field5\Field3
    Return $00
End Function
