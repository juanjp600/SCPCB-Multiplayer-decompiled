Function removeroom%(arg0.rooms)
    Local local0%
    For local0 = $00 To $02 Step $01
        arg0\Field21[local0] = $00
    Next
    For local0 = $00 To $1D Step $01
        If (arg0\Field11[local0] <> $00) Then
            entityparent(arg0\Field11[local0], $00, $01)
        EndIf
    Next
    For local0 = $00 To $1D Step $01
        If (arg0\Field11[local0] <> $00) Then
            freeentity(arg0\Field11[local0])
            arg0\Field11[local0] = $00
        EndIf
    Next
    If (arg0\Field30 <> $00) Then
        freeentity(arg0\Field30)
        arg0\Field30 = $00
    EndIf
    freeentity(arg0\Field2)
    arg0\Field2 = $00
    Delete arg0
    Return $00
End Function
