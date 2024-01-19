Function se_bl_array_delete%()
    Local local0.se_array
    Local local1%
    Local local2%
    Local local3%
    If (se_argtype($00) <> $07) Then
        Return $00
    EndIf
    local0 = se_arrayarg($00)
    local1 = (se_arguments_number - $01)
    For local2 = $01 To local1 Step $01
        local3 = se_tointarg(local2, $00)
        se_array_freeelement(local0, local3)
    Next
    Return $00
End Function
