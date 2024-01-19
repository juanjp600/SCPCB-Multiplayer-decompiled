Function public_update_by_func%(arg0.se_funcptr, arg1%)
    Local local0%
    Local local1%
    Local local2$[16]
    Local local3%[16]
    Local local4%
    local0 = publics\Field0
    local1 = publics\Field1
    For local4 = $01 To publics\Field1 Step $01
        local2[local4] = publics\Field2[local4]
        local3[local4] = publics\Field3[local4]
    Next
    If (arg0 <> Null) Then
        se_arguments_number = $00
        For local4 = $01 To publics\Field1 Step $01
            If (local4 > arg0\Field5) Then
                Exit
            EndIf
            Select publics\Field3[local4]
                Case $03
                    se_addstringarg(publics\Field2[local4])
                Case $01
                    se_addintarg((Int publics\Field2[local4]))
                Case $02
                    se_addfloatarg((Float publics\Field2[local4]))
                Case $00
                    se_addstringarg(publics\Field2[local4])
            End Select
        Next
        se_invokeuserfunction(arg0, $01)
    EndIf
    If (arg1 = $00) Then
        se_arguments_stack_level = $00
        se_arguments_number = $00
    EndIf
    publics\Field1 = local1
    publics\Field0 = local0
    For local4 = $01 To local1 Step $01
        publics\Field2[local4] = local2[local4]
        publics\Field3[local4] = local3[local4]
    Next
    Return $00
End Function
