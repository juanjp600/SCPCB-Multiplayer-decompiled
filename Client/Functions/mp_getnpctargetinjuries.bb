Function mp_getnpctargetinjuries#(arg0.npcs)
    If (arg0\Field85 <> 0) Then
        Return me\Field31
    EndIf
    If ((mp_ishoster() And (arg0\Field96 <> Null)) <> 0) Then
        Return arg0\Field96\Field4\Field6
    EndIf
    Return 0.0
    Return 0.0
End Function
