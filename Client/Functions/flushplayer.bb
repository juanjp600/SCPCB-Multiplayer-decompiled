Function flushplayer%(arg0.mp_player)
    If (arg0 = Null) Then
        Return $00
    EndIf
    mp_dropplayeritems(arg0)
    flushplayertags(arg0)
    flushplayermodel(arg0)
    flushplayerattaches(arg0)
    flushplayerpivot(arg0)
    flushplayervoice(arg0)
    If (arg0\Field4 <> Null) Then
        removeplayerlogic(arg0\Field4)
    EndIf
    Delete arg0\Field35
    Delete arg0
    mp_countplayers($FFFFFFFF)
    Return $01
    Return $00
End Function
