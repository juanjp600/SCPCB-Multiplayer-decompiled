Function updatemenuslidebar#(arg0%, arg1%, arg2%, arg3#, arg4%)
    Local local0.menuslidebar
    Local local1.menuslidebar
    Local local2%
    local2 = $00
    For local0 = Each menuslidebar
        If ((((local0\Field0 = arg0) And (local0\Field1 = arg1)) And (local0\Field2 = arg2)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        local0 = (New menuslidebar)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field3 = arg3
    Else
        local1 = local0
        local1\Field3 = arg3
    EndIf
    If ((mo\Field2 And (onsliderid = $00)) <> 0) Then
        If (mouseon(arg0, arg1, (Int ((14.0 * menuscale) + (Float arg2))), (Int (20.0 * menuscale))) <> 0) Then
            onsliderid = arg4
        EndIf
    EndIf
    If (arg4 = onsliderid) Then
        arg3 = clamp((((mouseposx - (Float arg0)) * 100.0) / (Float arg2)), 0.0, 100.0)
    EndIf
    Return floor(arg3)
    Return 0.0
End Function
