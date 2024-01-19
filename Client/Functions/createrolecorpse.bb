Function createrolecorpse%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%, arg7%, arg8%, arg9%)
    Local local0.breachtypes
    Local local1%
    Local local2%
    Local local3.p_obj
    local0 = getbreachtype(arg0)
    If (getsecondpackedvalue(local0\Field14) = $00) Then
        Return $00
    EndIf
    local1 = copyentity(local0\Field2, $00)
    positionentity(local1, arg1, ((arg2 - 0.32) - local0\Field52), arg3, $00)
    scaleentity(local1, (local0\Field3 * arg5), (local0\Field3 * arg5), (local0\Field3 * arg5), $00)
    rotateentity(local1, local0\Field54, (local0\Field53 + arg4), 0.0, $00)
    resetentity(local1)
    meshcullbox(local1, (- meshwidth(local0\Field2)), (- meshheight(local0\Field2)), (- meshdepth(local0\Field2)), (meshwidth(local0\Field2) * 2.0), (meshheight(local0\Field2) * 2.0), (meshdepth(local0\Field2) * 2.0))
    extractanimseq(local1, getfirstpackedvalue(local0\Field14), getsecondpackedvalue(local0\Field14), $00)
    animate(local1, $03, 0.5, $01, 0.0)
    If (local0\Field4 <> "") Then
        local2 = loadtexture_strict(local0\Field4, $01)
        entitytexture(local1, local2, $00, $00)
        freetexture(local2)
    EndIf
    If (arg6 <> 0) Then
        Return local1
    EndIf
    local3 = (New p_obj)
    local3\Field5 = arg0
    local3\Field3 = (millisecs() + $1D4C0)
    local3\Field4 = 350.0
    local3\Field0 = findfreecorpseid()
    local3\Field2 = local1
    local3\Field1 = arg9
    If (arg8 <> $00) Then
        local3\Field0 = arg8
    EndIf
    m_corpse[local3\Field0] = local3
    Return local1
    Return $00
End Function
