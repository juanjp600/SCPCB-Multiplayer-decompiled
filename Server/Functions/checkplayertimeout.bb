Function checkplayertimeout%(arg0.players)
    If (arg0\Field55 <> 0) Then
        Return $00
    EndIf
    If (arg0\Field23 < millisecs()) Then
        Return (kick(arg0\Field30, (arg0\Field15 + " has timed out!")) = $00)
    EndIf
    If (arg0\Field23 < (millisecs() + (server\Field13 - $7D0))) Then
        arg0\Field38 = ((((((readbool(arg0\Field38, $00) + (readbool(arg0\Field38, $01) Shl $01)) + (readbool(arg0\Field38, $02) Shl $02)) + $08) + (readbool(arg0\Field38, $04) Shl $04)) + (readbool(arg0\Field38, $05) Shl $05)) + (arg0\Field120 Shl $06))
    EndIf
    Return $00
End Function
