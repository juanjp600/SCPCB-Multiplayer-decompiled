Function setcolorraw%(arg0%)
    If (arg0 <> lastcolor) Then
        color(((arg0 Shr $10) And $FF), ((arg0 Shr $08) And $FF), (arg0 And $FF), $FF)
        lastcolor = arg0
        Return $01
    EndIf
    Return $00
    Return $00
End Function
