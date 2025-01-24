Function resetnegativestats%(arg0%)
    Local local0%
    Local local1%
    me\Field31 = 0.0
    me\Field32 = 0.0
    me\Field49 = 0.0
    me\Field51 = 0.0
    me\Field50 = 0.0
    me\Field23 = 0.0
    me\Field55 = 0.0
    me\Field4 = 0.0
    me\Field26 = 0.0
    me\Field30 = 0.0
    If (1.0 < me\Field12) Then
        me\Field12 = 1.0
        me\Field13 = 0.0
    EndIf
    me\Field15 = 0.0
    If (1.0 < me\Field18) Then
        me\Field18 = 1.0
        me\Field19 = 0.0
    EndIf
    me\Field17 = me\Field20
    For local1 = $00 To $06 Step $01
        i_1025\Field0[local1] = 0.0
    Next
    If (0.0 < i_1025\Field1[$00]) Then
        For local1 = (maxitemamount - $02) To (maxitemamount - $01) Step $01
            If (inventory(local1) <> Null) Then
                dropitem(inventory(local1), $01)
            EndIf
        Next
        maxitemamount = (maxitemamount - $02)
        i_1025\Field1[$00] = 0.0
    EndIf
    For local1 = $01 To $04 Step $01
        i_1025\Field1[local1] = 0.0
    Next
    If (25200.0 <= i_427\Field1) Then
        i_427\Field1 = 0.0
    EndIf
    i_008\Field0 = 0.0
    i_409\Field0 = 0.0
    i_1048a\Field0 = 0.0
    i_966\Field1 = 0.0
    i_966\Field0 = 0.0
    If (arg0 <> 0) Then
        If (mp_getsocket() = $00) Then
            clearcheats()
            If (1.0 = n_i\Field2\Field26) Then
                createconsolemsg(format(getlocalstring("console", "revive.by"), "SCP-173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                chs\Field0 = $01
                n_i\Field2\Field26 = 0.0
            EndIf
            If (4.0 > entitydistancesquared(me\Field60, n_i\Field3\Field3)) Then
                createconsolemsg(format(getlocalstring("console", "revive.by"), "SCP-106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                chs\Field0 = $01
            EndIf
            If (n_i\Field6 <> Null) Then
                n_i\Field6\Field10 = 1.0
                If (4.0 > entitydistancesquared(me\Field60, n_i\Field6\Field3)) Then
                    createconsolemsg(format(getlocalstring("console", "revive.by"), "SCP-049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    chs\Field0 = $01
                EndIf
            EndIf
        EndIf
        me\Field36 = -0.1
        me\Field37 = 0.0
        me\Field22 = 0.0
        me\Field38 = 0.0
        me\Field3 = 0.0
        menuopen = $00
        hideentity(me\Field61)
        showentity(me\Field60)
        me\Field0 = 0.0
        me\Field1 = $00
        rotateentity(camera, 0.0, 0.0, 0.0, $01)
    EndIf
    Return $00
End Function
