Function hideroomlights%(arg0.rooms)
    Local local0%
    If (arg0\Field71 = $00) Then
        For local0 = $00 To arg0\Field18 Step $01
            hideentity(arg0\Field24[local0])
            hideentity(arg0\Field16[local0])
            hideentity(arg0\Field21[local0])
            arg0\Field22[local0] = $01
            arg0\Field19[local0] = $01
        Next
        arg0\Field71 = $01
    EndIf
    Return $00
End Function
