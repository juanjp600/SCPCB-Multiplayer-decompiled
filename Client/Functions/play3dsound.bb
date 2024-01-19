Function play3dsound%(arg0%, arg1%, arg2%, arg3#, arg4#, arg5$)
    Local local0.snd3d
    local0 = (New snd3d)
    local0\Field5 = arg2
    local0\Field3 = arg3
    local0\Field4 = arg4
    If (arg5 = "") Then
        local0\Field2 = playsound2(arg0, arg1, arg2, arg3, arg4)
    Else
        local0\Field1 = loadsound_global(arg5)
        If (local0\Field1 = $00) Then
            Delete local0
            Return $00
        EndIf
        local0\Field2 = playsound(local0\Field1)
        updatesoundorigin(local0\Field2, camera, local0\Field5, local0\Field3, local0\Field4)
    EndIf
    Return local0\Field2
    Return $00
End Function
