Function flushplayerattaches%(arg0.mp_player)
    Local local0%
    For local0 = $00 To $09 Step $01
        Delete arg0\Field35\Field21[local0]
    Next
    Return $00
End Function
