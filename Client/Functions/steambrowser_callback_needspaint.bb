Function steambrowser_callback_needspaint%(arg0%, arg1%, arg2%)
    Local local0.steambrowser
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    If (steambrowser_callback_needspaint_p = $00) Then
        steambrowser_callback_needspaint_p = bp_getfunctionpointer()
        steambrowser_callback_needspaint_c = bs_callback_new(steambrowser_callback_needspaint_p)
        Return $00
    EndIf
    local0 = steambrowser_find(bs_memory_peekint(arg0, $00), $00)
    If (local0 <> Null) Then
        local1 = bs_memory_peekint(arg0, $04)
        local2 = bs_memory_peekint(arg0, $08)
        local3 = bs_memory_peekint(arg0, $0C)
        local4 = bs_memory_peekint(arg0, $10)
        local5 = bs_memory_peekint(arg0, $14)
        local6 = bs_memory_peekint(arg0, $18)
        local7 = bs_memory_peekint(arg0, $1C)
        local8 = bs_memory_peekint(arg0, $20)
        local9 = bs_memory_peekint(arg0, $24)
        local10 = bs_memory_peekfloat(arg0, $28)
        local11 = bs_memory_peekint(arg0, $2C)
        local0\Field4[$00] = local4
        local0\Field4[$01] = local5
        local0\Field4[$02] = local6
        local0\Field4[$03] = local7
        local0\Field6 = local10
        local0\Field7 = local8
        local0\Field8 = local9
        local0\Field5 = local11
        local12 = (Int (ceil(((Float local2) / 16.0)) * 16.0))
        If (local0\Field9 <> $00) Then
            local13 = imagebuffer(local0\Field9, $00)
            lockbuffer(local13)
            bs_helper_copymemoryintmangle(local1, bs_memory_peekint(local13, $48), $00, local2, local3, local12, local0\Field2[$01], local4, local5, local6, local7)
            unlockbuffer(local13)
        EndIf
        If (local0\Field10 <> $00) Then
            local14 = texturebuffer(local0\Field10, $00)
            lockbuffer(local14)
            bs_helper_copymemoryintmangle(local1, bs_memory_peekint(local14, $48), $00, local2, local3, local12, local0\Field2[$01], local4, local5, local6, local7)
            unlockbuffer(local14)
        EndIf
    EndIf
    Return $00
End Function
