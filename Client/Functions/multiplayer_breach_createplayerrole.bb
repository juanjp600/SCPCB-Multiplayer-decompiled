Function multiplayer_breach_createplayerrole%(arg0$, arg1%, arg2#, arg3$, arg4%, arg5%, arg6%, arg7%)
    Local local0.breachtypes
    local0 = (New breachtypes)
    local0\Field0 = arg0
    local0\Field1 = last_breach_type
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field5 = arg4
    local0\Field6 = arg5
    local0\Field7 = arg6
    local0\Field4 = arg3
    local0\Field8 = arg7
    local0\Field24[$01] = "Bip01_Head"
    local0\Field24[$02] = "FIRESPOT"
    local0\Field24[$03] = "Bip01_Spine1"
    local0\Field24[$04] = "Bip01_Spine2"
    local0\Field24[$05] = "Bip01_R_Forearm"
    local0\Field31 = $01
    local0\Field52 = 0.3
    local0\Field53 = -180.0
    local0\Field54 = 0.0
    local0\Field58 = local0\Field1
    local0\Field42 = local0\Field1
    breachtypesarray[local0\Field1] = local0
    last_breach_type = (last_breach_type + $01)
    Return local0\Field1
    Return $00
End Function
