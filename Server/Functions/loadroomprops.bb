Function loadroomprops%(arg0.rooms)
    Local local0%
    Local local1.props
    If (arg0\Field7 <> Null) Then
        local0 = $00
        For local1 = Each props
            If (local1\Field11 = arg0\Field7) Then
                local0 = copyentity(local1\Field1, $00)
                entityparent(local0, arg0\Field2, $01)
                positionentity(local0, local1\Field2, local1\Field3, local1\Field4, $00)
                rotateentity(local0, local1\Field8, local1\Field9, local1\Field10, $00)
                scaleentity(local0, local1\Field5, local1\Field6, local1\Field7, $00)
                entitytype(local0, $01, $00)
            EndIf
        Next
    EndIf
    Return $00
End Function
