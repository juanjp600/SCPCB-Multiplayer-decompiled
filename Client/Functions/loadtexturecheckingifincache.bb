Function loadtexturecheckingifincache%(arg0$, arg1%, arg2%)
    Local local0.textureincache
    Local local1$
    If (arg0 = "") Then
        Return $00
    EndIf
    For local0 = Each textureincache
        If (local0\Field1 <> "CTUCS") Then
            If (strippath(arg0) = local0\Field1) Then
                If (local0\Field2 < arg2) Then
                    local0\Field2 = arg2
                EndIf
                Return local0\Field0
            EndIf
        EndIf
    Next
    local1 = arg0
    local0 = (New textureincache)
    local0\Field1 = strippath(arg0)
    local0\Field2 = arg2
    If (filetype((lang\Field1 + local1)) = $01) Then
        local1 = (lang\Field1 + local1)
    EndIf
    If (local0\Field0 = $00) Then
        local0\Field0 = loadtexture(local1, arg1)
    EndIf
    If ((((opt\Field51 = $00) And (local0\Field0 <> $00)) And (texturebuffer(local0\Field0, $00) <> $00)) <> 0) Then
        bufferdirty(texturebuffer(local0\Field0, $00))
    EndIf
    Return local0\Field0
    Return $00
End Function
