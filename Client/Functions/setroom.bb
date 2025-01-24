Function setroom%(arg0%, arg1%, arg2$, arg3#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local1 = $00
    For local0 = $00 To (arg0 - $01) Step $01
        local1 = (local1 + roomamount(arg1, local0))
    Next
    local2 = ((roomamount(arg1, arg0) + local1) - $01)
    If (local2 < local1) Then
        Return $00
    EndIf
    arg3 = clamp(arg3, 0.0, 1.0)
    local3 = (Int (floor((arg3 * (Float (local2 - local1)))) + (Float local1)))
    If (maproom(arg1, local3) = "") Then
        maproom(arg1, local3) = arg2
        Return $01
    EndIf
    local4 = (Int max((Float (local2 - local3)), (Float (local3 - local1))))
    For local5 = $01 To local4 Step $01
        If ((((local3 + local5) <= local2) And (maproom(arg1, (local3 + local5)) = "")) <> 0) Then
            maproom(arg1, (local3 + local5)) = arg2
            Return $01
        EndIf
        If ((((local3 - local5) >= local1) And (maproom(arg1, (local3 - local5)) = "")) <> 0) Then
            maproom(arg1, (local3 - local5)) = arg2
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
