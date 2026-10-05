Function setcamerazoom%(arg0#, arg1%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    If (arg1 <> 0) Then
        Goto lllllll
    EndIf
    If (mainfov = arg0) Then
        Return $00
    EndIf
.lllllll
    If (0.0 = invaspectratio) Then
        invaspectratio = (1.0 / ((Float win\Field2) / (Float win\Field3)))
    EndIf
    local0 = 1.1
    local1 = (arg0 * (1.0 / 114.6))
    local2 = ((((local1 * local1) * local1) * 0.333) + local1)
    local3 = ((local0 * invaspectratio) / local2)
    camerazoom(camera, local3)
    camerazoom(landscapecamera, local3)
    currcamerazoom = arg0
    Return $00
End Function
