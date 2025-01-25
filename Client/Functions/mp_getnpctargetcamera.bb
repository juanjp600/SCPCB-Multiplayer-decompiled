Function mp_getnpctargetcamera%(arg0.npcs)
    If (arg0\Field83 <> 0) Then
        Return camera
    EndIf
    If ((mp_ishoster() And (arg0\Field94 <> Null)) <> 0) Then
        Return arg0\Field94\Field19
    EndIf
    Return camera
    Return $00
End Function
