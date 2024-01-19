Function public_update_lua%(arg0%, arg1$)
    Local local0%
    Local local1%
    Local local2$[16]
    Local local3%[16]
    Local local4%
    Local local6$
    local0 = publics\Field0
    local1 = publics\Field1
    For local4 = $01 To publics\Field1 Step $01
        local2[local4] = publics\Field2[local4]
        local3[local4] = publics\Field3[local4]
    Next
    If (slua_sc_set_function_single(arg0, arg1) = $01) Then
        For local4 = $01 To publics\Field1 Step $01
            Select publics\Field3[local4]
                Case $03
                    slua_push_string(arg0, publics\Field2[local4])
                Case $01
                    slua_push_integer(arg0, (Int publics\Field2[local4]))
                Case $02
                    slua_push_number(arg0, (Float publics\Field2[local4]))
                Case $00
                    slua_push_nil(arg0)
            End Select
        Next
        local6 = slua_sc_invoke_single_str(arg0, publics\Field1)
        If (local6 = "0") Then
            se_return_value\Field8 = $01
        EndIf
        se_returnstring(local6)
    EndIf
    publics\Field1 = local1
    publics\Field0 = local0
    For local4 = $01 To local1 Step $01
        publics\Field2[local4] = local2[local4]
        publics\Field3[local4] = local3[local4]
    Next
    Return $00
End Function
