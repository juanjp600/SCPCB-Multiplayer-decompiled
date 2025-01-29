Function mp_getnpctargetdead%(arg0.npcs)
    If (arg0\Field85 <> 0) Then
        Return (Int me\Field0)
    EndIf
    If ((mp_ishoster() And (arg0\Field96 <> Null)) <> 0) Then
        Return arg0\Field96\Field4\Field4
    EndIf
    Return $00
    Return $00
End Function
