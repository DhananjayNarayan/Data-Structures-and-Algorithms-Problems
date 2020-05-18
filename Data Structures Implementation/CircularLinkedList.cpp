
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
102
103
104
105
106
107
108
109
110
111
112
113
114
115
116
117
118
119
120
121
122
123
124
125
126
127
128
129
130
131
132
133
134
135
136
137
138
139
140
141
142
143
144
145
146
147
148
149
150
151
152
153
154
155
156
157
158
159
160
161
162
163
164
165
166
167
168
169
170
171
172
173
174
175
176
177
178
179
180
181
182
183
184
185
186
187
188
189
190
191
192
193
194
195
196
197
198
199
200
201
202
203
204
205
206
207
208
209
210
211
212
213
214
215
216
217
218
219
220
221
222
223
224
225
226
227
228
229
230
231
232
233
234
235
236
237
238
239
240
241
242
243
244
245
246
247
248
249
250
251
252
253
254
255
256
257
258
259
260
261
262
263
264
265
266
267
268
269
270
271
272
273
274
275
276
277
278
279
280
281
282
283
284
285
286
#include<iostream>
 
using namespace std;
 
class Node {
  public:
    int key;
  int data;
  Node * next;
 
  Node() {
    key = 0;
    data = 0;
    next = NULL;
  }
  Node(int k, int d) {
    key = k;
    data = d;
  }
};
 
class CircularLinkedList {
  public:
    Node * head;
 
  CircularLinkedList() {
    head = NULL;
  }
 
  // 1. CHeck if node exists using key value
  Node * nodeExists(int k) {
 
    Node * temp = NULL;
    Node * ptr = head;
 
    if (ptr == NULL) {
      return temp;
    } else {
      do {
        if (ptr - > key == k) {
          temp = ptr;
        }
        ptr = ptr - > next;
 
      } while (ptr != head);
      return temp;
    }
 
    //return temp;
  }
 
  // 2. Append a node to the list
  void appendNode(Node * new_node) {
    if (nodeExists(new_node - > key) != NULL) {
      cout << "Node Already exists with key value : " <<
        new_node - > key <<
        ". Append another node with different Key value" <<
        endl;
    } else {
      if (head == NULL) {
        head = new_node;
        new_node - > next = head;
        cout << "Node Appended at first Head position" << endl;
      } else {
        Node * ptr = head;
        while (ptr - > next != head) {
          ptr = ptr - > next;
        }
        ptr - > next = new_node;
        new_node - > next = head;
        cout << "Node Appended" << endl;
      }
    }
 
  }
  // 3. Prepend Node - Attach a node at the start
  void prependNode(Node * new_node) {
    if (nodeExists(new_node - > key) != NULL) {
      cout << "Node Already exists with key value : " <<
        new_node - > key <<
        ". Append another node with different Key value" <<
        endl;
    } else {
      if (head == NULL) {
        head = new_node;
        new_node - > next = head;
        cout << "Node Prepended at first Head position" << endl;
      } else {
        Node * ptr = head;
        while (ptr - > next != head) {
          ptr = ptr - > next;
        }
 
        ptr - > next = new_node;
        new_node - > next = head;
        head = new_node;
        cout << "Node Prepended" << endl;
      }
 
    }
  }
 
  // 4. Insert a Node after a particular node in the list
  void insertNodeAfter(int k, Node * new_node) {
    Node * ptr = nodeExists(k);
    if (ptr == NULL) {
      cout << "No node exists with key value OF: " << k << endl;
    } else {
      if (nodeExists(new_node - > key) != NULL) {
        cout << "Node Already exists with key value : " <<
          new_node - > key <<
          ". Append another node with different Key value" <<
          endl;
      } else {
        if (ptr - > next == head) {
          new_node - > next = head;
          ptr - > next = new_node;
          cout << "Node Inserted at the End" << endl;
        } else {
          new_node - > next = ptr - > next;
          ptr - > next = new_node;
          cout << "Node Inserted in between" << endl;
        }
 
      }
    }
  }
 
  // 5. Delete node by unique key
  void deleteNodeByKey(int k) {
    Node * ptr = nodeExists(k);
    if (ptr == NULL) {
      cout << "No node exists with key value OF : " << k <<
        endl;
    } else {
 
      if (ptr == head) {
        if (head - > next == NULL) {
          head = NULL;
          cout << "Head node Unlinked... List Empty";
        } else {
          Node * ptr1 = head;
          while (ptr1 - > next != head) {
            ptr1 = ptr1 - > next;
          }
          ptr1 - > next = head - > next;
          head = head - > next;
          cout << "Node UNLINKED with keys value : " << k << endl;
        }
      } else {
        Node * temp = NULL;
        Node * prevptr = head;
        Node * currentptr = head - > next;
        while (currentptr != NULL) {
          if (currentptr - > key == k) {
            temp = currentptr;
            currentptr = NULL;
          } else {
            prevptr = prevptr - > next;
            currentptr = currentptr - > next;
          }
        }
 
        prevptr - > next = temp - > next;
        cout << "Node UNLINKED with keys value : " << k << endl;
 
      }
 
    }
 
  }
  // 6th update node
  void updateNodeByKey(int k, int new_data) {
 
    Node * ptr = nodeExists(k);
    if (ptr != NULL) {
      ptr - > data = new_data;
      cout << "Node Data Updated Successfully" << endl;
    } else {
      cout << "Node Doesn't exist with key value : " << k << endl;
    }
 
  }
 
  // 7th printing
  void printList() {
    if (head == NULL) {
      cout << "No Nodes in Circular Linked List";
    } else {
      cout << endl << "head address : " << head << endl;
      cout << "Circular Linked List Values : " << endl;
 
      Node * temp = head;
 
      do {
        cout << "(" << temp - > key << "," << temp - > data << "," << temp - > next << ") --> ";
        temp = temp - > next;
      } while (temp != head);
    }
 
  }
 
};
 
int main() {
 
  CircularLinkedList obj;
  int option;
  int key1, k1, data1;
  do {
    cout << "\nWhat operation do you want to perform? Select Option number. Enter 0 to exit." << endl;
    cout << "1. appendNode()" << endl;
    cout << "2. prependNode()" << endl;
    cout << "3. insertNodeAfter()" << endl;
    cout << "4. deleteNodeByKey()" << endl;
    cout << "5. updateNodeByKey()" << endl;
    cout << "6. print()" << endl;
    cout << "7. Clear Screen" << endl << endl;
 
    cin >> option;
    Node * n1 = new Node();
    //Node n1;
 
    switch (option) {
    case 0:
      break;
    case 1:
      cout << "Append Node Operation \nEnter key & data of the Node to be Appended" << endl;
      cin >> key1;
      cin >> data1;
      n1 - > key = key1;
      n1 - > data = data1;
      obj.appendNode(n1);
      //cout<<n1.key<<" = "<<n1.data<<endl;
      break;
 
    case 2:
      cout << "Prepend Node Operation \nEnter key & data of the Node to be Prepended" << endl;
      cin >> key1;
      cin >> data1;
      n1 - > key = key1;
      n1 - > data = data1;
      obj.prependNode(n1);
      break;
 
    case 3:
      cout << "Insert Node After Operation \nEnter key of existing Node after which you want to Insert this New node: " << endl;
      cin >> k1;
      cout << "Enter key & data of the New Node first: " << endl;
      cin >> key1;
      cin >> data1;
      n1 - > key = key1;
      n1 - > data = data1;
 
      obj.insertNodeAfter(k1, n1);
      break;
 
    case 4:
 
      cout << "Delete Node By Key Operation - \nEnter key of the Node to be deleted: " << endl;
      cin >> k1;
      obj.deleteNodeByKey(k1);
 
      break;
    case 5:
      cout << "Update Node By Key Operation - \nEnter key & NEW data to be updated" << endl;
      cin >> key1;
      cin >> data1;
      obj.updateNodeByKey(key1, data1);
 
      break;
    case 6:
      obj.printList();
 
      break;
    case 7:
      system("cls");
      break;
    default:
      cout << "Enter Proper Option number " << endl;
    }
 
  } while (option != 0);
 
  return 0;
}
