Function init_publics_for_script%(arg0.se_script)
    Local local0%
    For local0 = $01 To $FF Step $01
        If (public_getname(local0) <> "") Then
            arg0\Field8[local0] = se_findfunc(arg0, lower(public_getname(local0)))
        EndIf
    Next
    Return $00
End Function
