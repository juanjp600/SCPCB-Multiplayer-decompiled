Function checkformultiplayerinfacility%(arg0%)
    If (100.0 < entityy(arg0, $00)) Then
        Return $00
    EndIf
    If (-10.0 > entityy(arg0, $00)) Then
        Return $02
    EndIf
    If (((7.0 < entityy(arg0, $00)) And (100.0 >= entityy(arg0, $00))) <> 0) Then
        Return $02
    EndIf
    Return $01
    Return $00
End Function
