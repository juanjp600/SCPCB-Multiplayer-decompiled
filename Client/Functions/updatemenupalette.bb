Function updatemenupalette%(arg0%, arg1%)
    Local local0.menupalette
    Local local1%
    local1 = $00
    For local0 = Each menupalette
        If (((local0\Field1 = arg0) And (local0\Field2 = arg1)) <> 0) Then
            local1 = $01
            Exit
        EndIf
    Next
    If (local1 = $00) Then
        local0 = (New menupalette)
        If (local0\Field0 = $00) Then
            local0\Field0 = scaleimageex(loadimage_strict("GFX\Menu\palette.png"), menuscale, menuscale, $01)
        EndIf
        local0\Field1 = arg0
        local0\Field2 = arg1
        local0\Field3 = imagewidth(local0\Field0)
        local0\Field4 = imageheight(local0\Field0)
    EndIf
    onpalette = mouseon(arg0, arg1, local0\Field3, local0\Field4)
    Return $00
End Function
