Function multiplayer_breach_createplayerrole%(arg0$, arg1%, arg2#, arg3$, arg4%, arg5%, arg6%, arg7%)
    Local local0.breachtypes
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
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
    local0\Field22[local1] = "Bip01_Head"
    local0\Field22[local2] = "FIRESPOT"
    local0\Field22[local3] = "Bip01_Spine1"
    local0\Field22[local4] = "Bip01_Spine2"
    local0\Field22[local5] = "Bip01_R_Forearm"
    local0\Field29 = $01
    local0\Field59 = $01
    local0\Field60 = local0\Field1
    local0\Field40 = local0\Field1
    local0\Field58 = $01
    breachtypesarray[local0\Field1] = local0
    last_breach_type = (last_breach_type + $01)
    Return local0\Field1
    Return $00
End Function
