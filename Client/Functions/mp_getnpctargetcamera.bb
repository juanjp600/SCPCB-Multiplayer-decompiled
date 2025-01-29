Function mp_getnpctargetcamera%(arg0.npcs)
    If (arg0\Field85 <> 0) Then
        Return camera
    EndIf
    If ((mp_ishoster() And (arg0\Field96 <> Null)) <> 0) Then
        Return arg0\Field96\Field19
    EndIf
    Return camera
    Return $00
End Function
