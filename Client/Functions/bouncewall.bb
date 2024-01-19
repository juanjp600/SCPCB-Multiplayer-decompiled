Function bouncewall#(arg0#, arg1#)
    Local local0.bvector
    Local local1#
    local0 = bbounce(bcreatevector(sin(arg0), cos(arg0)), bcreatevector(sin(arg1), cos(arg1)))
    local1 = vectoryaw(local0\Field0, 0.0, local0\Field1)
    Delete Each bvector
    Return local1
    Return 0.0
End Function
