Function applyreflection%(arg0%)
    If (((arg0 <> $00) And (env_reflective <> $00)) <> 0) Then
        entitytexture(arg0, env_reflective, $00, $07)
    EndIf
    Return $00
End Function
