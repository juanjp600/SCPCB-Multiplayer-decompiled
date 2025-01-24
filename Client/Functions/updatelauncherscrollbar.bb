Function updatelauncherscrollbar#(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6#, arg7%)
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    local0 = (Float mousexspeed())
    local1 = (Float mouseyspeed())
    local2 = (arg5 Sar $01)
    color($00, $00, $00)
    updatelauncherdownloadbutton(arg2, arg3, arg4, arg5, "", $00)
    If (arg7 <> 0) Then
        If (arg0 > $0A) Then
            color($FF, $FF, $FF)
            rect((arg2 + $04), (arg3 + local2), (arg4 - $0A), $02, $01)
            rect((arg2 + $04), ((arg3 + local2) - $03), (arg4 - $0A), $02, $01)
            rect((arg2 + $04), ((arg3 + local2) + $03), (arg4 - $0A), $02, $01)
        EndIf
    ElseIf (arg1 > $0A) Then
        color($FF, $FF, $FF)
        rect((arg2 + local2), (arg3 + $05), $02, (arg5 - $0A), $01)
        rect(((arg2 + local2) - $03), (arg3 + $05), $02, (arg5 - $0A), $01)
        rect(((arg2 + local2) + $03), (arg3 + $05), $02, (arg5 - $0A), $01)
    EndIf
    onscrollbar = (mo\Field2 And mouseon(arg2, arg3, arg4, arg5))
    If (onscrollbar <> 0) Then
        If (arg7 <> 0) Then
            Return clamp(((local1 / (Float (arg1 - arg5))) + arg6), 0.0, 1.0)
        Else
            Return clamp(((local0 / (Float (arg0 - arg4))) + arg6), 0.0, 1.0)
        EndIf
    EndIf
    local3 = (Float mousezspeed())
    If (0.0 <> local3) Then
        Return clamp((arg6 - ((local3 * 3.0) / (Float (arg1 - arg5)))), 0.0, 1.0)
    EndIf
    Return arg6
    Return 0.0
End Function
