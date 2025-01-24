Function changenpctextureid%(arg0.npcs, arg1%)
    If (arg0 = Null) Then
        openconsoleonerror(getlocalstring("msg", "spawn.invaildtex"))
        Return $00
    EndIf
    If (((arg0\Field62 <> (arg1 + $01)) And (arg1 < $16)) <> 0) Then
        arg0\Field62 = (arg1 + $01)
        entitytexture(arg0\Field0, n_i\Field1[arg1], $00, $00)
        If (arg0\Field4 = $07) Then
            entitytexture(arg0\Field1, n_i\Field1[arg1], $00, $00)
        EndIf
    EndIf
    Return $00
End Function
